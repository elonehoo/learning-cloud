package com.inet.code.service.Impl;

import cn.hutool.core.util.ReUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.inet.code.entity.dto.TopicDTO;
import com.inet.code.entity.po.DailyReport;
import com.inet.code.entity.po.Topic;
import com.inet.code.entity.po.TopicLabel;
import com.inet.code.entity.vo.TopicVO;
import com.inet.code.mapper.TopicMapper;
import com.inet.code.service.TopicLabelService;
import com.inet.code.service.TopicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * 题目服务层
 * @author: hlj
 * @date: 2021-06-05
*/
@Service
public class TopicServiceImpl implements TopicService {
    private static String url_1="";
    private static int page=1;
    private static final int END_PAGE = 100;

    @Resource
    private TopicMapper topicMapper;

    @Resource
    private TopicLabelService topicLabelService;

    /**
     * 根据题目标题进行题目的查找,支持模糊查询,每次查询 4个/有限页面内的 题目
     * @param website 拉取题目的网页
     * @param title 题目标题，支持模糊查询
     * @return String 返回搜索到的题目
     */
    @Override
    public List<TopicVO> selectTopicByTitle(String website, String title) {
        List<TopicVO> topicVOList ;
        switch (website){
            case "https://leetcode-cn.com":
                topicVOList = getTopicByLeetCode(title);
                break;
            case "https://www.nowcoder.com":
                topicVOList = new ArrayList<>();
                getTopicByNowCoder(title,topicVOList);
                break;
            case "https://nanti.jisuanke.com":
                topicVOList = new ArrayList<>();
                getTopicByJisuanke(title,topicVOList);
                break;
            default:
                topicVOList = null;
        }
        return topicVOList;
    }

    /**
     * 根据题目ID进行查找,目前只有力扣网支持,其他网站我找不到ID
     * @param website 拉取题目的网页
     * @param id 题目标题，支持模糊查询
     * @return String 返回搜索到的题目
     */
    @Override
    public TopicVO selectTopicById(String website, int id) {
        if("https://leetcode-cn.com".equals(website)){
            return getTopicByLeetCode(id);
        }else {
            return new TopicVO();
        }
    }

    /**
     * 增加一条来自网页的题目
     * @param topicDTO 题目传输类
     * @param labelId 题目标签ID
     * @return boolean 返回插入是否成功
     */
    @Override
    public boolean saveTopicFromWebsite(TopicDTO topicDTO, String labelId) {
        String uuid = UUID.randomUUID().toString();
        Topic topic = new Topic(uuid,topicDTO.getOriginUrl(),topicDTO.getIssuerUserId(),topicDTO.getAuthor(),topicDTO.getLevel(),labelId,topicDTO.getHeadline(),topicDTO.getContent());
        int row = topicMapper.insertTopicFromWebsite(topic);
        TopicLabel topicLabel = new TopicLabel(UUID.randomUUID().toString(),uuid,labelId);
        boolean b = topicLabelService.saveTopicLabelFromWebsite(topicLabel);
        return row>=1 && b;
    }




    /**
     * 根据题目标题查找力扣网题目，支持模糊查询
     * @param title 题目标题
     * @return List<TopicVO> 返回一个题目列表
    */
    private static List<TopicVO> getTopicByLeetCode(String title){
        String data = "{\"operationName\":\"getQuestionTranslation\",\"variables\":{},\"query\":\"query getQuestionTranslation($lang: String) {\\n  translations: allAppliedQuestionTranslations(lang: $lang) {\\n    title\\n    questionId\\n    __typename\\n  }\\n}\\n\"}";
        JSON topicJson = JSONUtil.parse(HttpRequest.post("https://leetcode-cn.com/graphql")
                .header("content-type", "application/json")
                .body(data)
                .timeout(10000)
                .execute()
                .body());
        List<TopicVO> topicVOList = new ArrayList<>();
        int count = 0;
        JSONArray jsonArray =topicJson.getByPath("data",JSON.class).getByPath("translations",JSONArray.class);
        for(Object json:jsonArray){
            if (JSONUtil.parse(json).getByPath("title",String.class).contains(title)){
                topicVOList.add(getTopicByLeetCode(JSONUtil.parse(json).getByPath("questionId",Integer.class)));
                if (++count>4 ) {
                    return topicVOList;
                }
            }
        }
        return topicVOList;
    }

    /**
     * 根据题目ID查找力扣网题目
     * @param id 题目ID
     * @return TopicVO 返回一个题目
    */
    private static TopicVO getTopicByLeetCode(int id){
        JSON topicJson = JSONUtil.parse(HttpRequest.get("https://leetcode-cn.com/api/problems/all/")
                .timeout(10000)
                .execute()
                .body());
        TopicVO topicVO = null;
        JSONArray jsonArray =topicJson.getByPath("stat_status_pairs",JSONArray.class);
        for(Object json:jsonArray){
            if(id == JSONUtil.parse(json).getByPath("stat",JSON.class).getByPath("question_id",Integer.class)){
                topicVO = getTopicMsg(JSONUtil.parse(json).getByPath("stat",JSON.class).getByPath("question__title_slug",String.class));
                topicVO.setLevel(JSONUtil.parse(json).getByPath("difficulty",JSON.class).getByPath("level",Integer.class));
                topicVO.setAuthor("leetcode-cn.com");
            }
        }
        return topicVO;
    }

    /**
     * 根据题目链接索引查找力扣网题目信息
     * @param str 题目标题链接索引
     * @return TopicVO 返回一个题目
    */
    private static TopicVO getTopicMsg(String str){
        String data = "{\"operationName\":\"questionData\",\"variables\":{\"titleSlug\":\""+str+"\"},\"query\":\"query questionData($titleSlug: String!) {\\n  question(titleSlug: $titleSlug) {\\n    questionId\\n    questionFrontendId\\n    categoryTitle\\n    boundTopicId\\n    title\\n    titleSlug\\n    content\\n    translatedTitle\\n    translatedContent\\n    isPaidOnly\\n    difficulty\\n    likes\\n    dislikes\\n    isLiked\\n    similarQuestions\\n    contributors {\\n      username\\n      profileUrl\\n      avatarUrl\\n      __typename\\n    }\\n    langToValidPlayground\\n    topicTags {\\n      name\\n      slug\\n      translatedName\\n      __typename\\n    }\\n    companyTagStats\\n    codeSnippets {\\n      lang\\n      langSlug\\n      code\\n      __typename\\n    }\\n    stats\\n    hints\\n    solution {\\n      id\\n      canSeeDetail\\n      __typename\\n    }\\n    status\\n    sampleTestCase\\n    metaData\\n    judgerAvailable\\n    judgeType\\n    mysqlSchemas\\n    enableRunCode\\n    envInfo\\n    book {\\n      id\\n      bookName\\n      pressName\\n      source\\n      shortDescription\\n      fullDescription\\n      bookImgUrl\\n      pressImgUrl\\n      productUrl\\n      __typename\\n    }\\n    isSubscribed\\n    isDailyQuestion\\n    dailyRecordStatus\\n    editorType\\n    ugcQuestionId\\n    style\\n    exampleTestcases\\n    __typename\\n  }\\n}\\n\"}";
        JSON json = JSONUtil.parse(HttpRequest.post("https://leetcode-cn.com/graphql")
                .header("content-type", "application/json")
                .body(data)
                .execute()
                .body());
        TopicVO topicVO = new TopicVO();
        if(json.getByPath("data",JSON.class).getByPath("question") != null){
            topicVO.setContent(ReUtil.delAll("<(.+?)>",json.getByPath("data",JSON.class).getByPath("question",JSON.class).getByPath("translatedContent",String.class)));
            topicVO.setTitle(json.getByPath("data",JSON.class).getByPath("question",JSON.class).getByPath("translatedTitle",String.class));
        }
        return topicVO;
    }

    /**
     * 根据题目标题查找牛客网题目，支持模糊查询，并拿取题目信息放到题目列表中
     * @param title 题目标题
     * @param topicVOList 题目列表，用于返回得到的题目
     */
    private static void getTopicByNowCoder(String title,List<TopicVO> topicVOList){
        if(url_1 == null || ++page > END_PAGE){
            page=1;
            return;
        }
        TopicVO topicVO = new TopicVO();
        String html = HttpUtil.get("https://www.nowcoder.com/questionCenter"+url_1);
        String u = ReUtil.get(Pattern.compile("<a href='/questionTerminal/(.+?)'\ntarget=\"_blank\">\n.*?"+title+".*?\n</a>"), html, 1);
        if(u != null){
            String htmlTopic = HttpUtil.get("https://www.nowcoder.com/questionTerminal/"+u);
            topicVO.setTitle( ReUtil.delAll("__(.+?)",ReUtil.get("<title>(.+?)</title>",htmlTopic,1)));
            String content = ReUtil.delAll("\n<(.+?)>\n",ReUtil.get("<div class=\"subject-des\">\n(.+?)\n</div>",htmlTopic,1));
            content =ReUtil.delAll("<(.+?)>",content);
            String answer = ReUtil.delAll("<(.+?)>",ReUtil.get("<ul class=\"subject-des-list\">\n(.+?)\n<ul>",htmlTopic,1));
            if(answer != null){
                content+="\n"+answer;
            }
            topicVO.setContent(content);
            switch (ReUtil.get("<span class=\"q-level-label\">难度：</span><span\nclass=\"stars-new star-(.+?)\"></span>",htmlTopic,1)){
                case "3":
                    topicVO.setLevel(1);
                    break;
                case "4":
                case "5":
                    topicVO.setLevel(2);
                    break;
                default:
                    topicVO.setLevel(0);
                    break;
            }
            topicVO.setAuthor(ReUtil.get(Pattern.compile("上传者：<a href=\"/profile/.+?\" class=\"kind-link\">(.+?)</a>"),htmlTopic,1));
            topicVOList.add(topicVO);
        }
        url_1 = ReUtil.get("<li class=\"txt-pager js-next-pager\"><a data-page=\"(.*?)\" href=\"/questionCenter(.+?)\">下一页</a>",html,2);
        getTopicByNowCoder(title,topicVOList);
    }

    /**
     * 根据题目标题查找计蒜客网题目，支持模糊查询，并拿取题目信息放到题目列表中
     * @param title 题目标题
     * @param topicVOList 题目列表，用于返回得到的题目
     */
    public static void getTopicByJisuanke(String title,List<TopicVO> topicVOList){
        String html = HttpUtil.get("https://nanti.jisuanke.com"+"/oi?kw=&sort=&status=&tags=&page="+page++);

        if(ReUtil.findAll(Pattern.compile("<a href=\"(.+?)\" target=\"_blank\">(.+?)\n(.+?)<span>(.+?)</span></a>"),html,1).isEmpty() || page > END_PAGE){
            page=1;
            return;
        }else {
            TopicVO topicVO = new TopicVO();
            if(ReUtil.get(Pattern.compile("<a href=\"(.+?)\" target=\"_blank\">(.+?)\n.*?<span>.*?"+title+".*?</span></a>"),html,1) != null){
                String htmlTopic = HttpUtil.get("https://nanti.jisuanke.com"+ReUtil.get(Pattern.compile("<a href=\"(.+?)\" target=\"_blank\">(.+?)\n.*?<span>.*?"+title+".*?</span></a>"),html,1));
                JSON json =JSONUtil.parse(ReUtil.get("<script type=\"text/javascript\">var nanti_id=(.+?);var problem=(.+?);var user_editor_theme=\"jsk-monokai\"", htmlTopic, 2));
                topicVO.setTitle(json.getByPath("title",String.class));
                String content = ReUtil.delAll("<.+?>",json.getByPath("description").toString());
                content += "\n样例输入：\n"+json.getByPath("sample_input");
                content += "\n样例输出：\n"+json.getByPath("sample_output");
                topicVO.setContent(content);
                switch (ReUtil.get(Pattern.compile("<a href=\"(.+?)\" target=\"_blank\">(.+?)\n.*?<span>.*?" + title + ".*?</span></a></span> <!----> <span class=\"jsk-fr problem-tag difficulty-tag jsk-text-xs\">(.+?)\n.+?</span>"), html, 3)){
                    case "普及T4/提高T1":
                    case "提高T2":
                    case "提高T3":
                        topicVO.setLevel(1);
                        break;
                    case "提高T4/省选":
                    case "NOI/CTS/IOI":
                        topicVO.setLevel(2);
                        break;
                    default:
                        topicVO.setLevel(0);
                        break;
                }
                topicVO.setAuthor("https://nanti.jisuanke.com");
                topicVOList.add(topicVO);

            }
        }
        getTopicByJisuanke(title,topicVOList);

    }
}
