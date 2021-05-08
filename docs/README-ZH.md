> 这是 杭州科技职业技术学院 的 2019 开源项目
****
## 文件目录
```markdown
> [hzpt-controller](控制层用于控制API接口和服务层的调用)
> [hzpt-jurisdiction](权限层，用于控制权限的使用和部署)
> [hzpt-mapper](持久层，与数据库一对一对应)
> ......
```
****
## 作者目录
```markdown
> []()
> [晓寻遥](https://github.com/xiaoxunyao)
> []()
> []()
> [秋叶](https://github.com/qiuqiuya-get)
> []()
> [李清风](https://github.com/Annnnnnovice)
> []()
> []()
```
****
## 项目目录
****
> 
```markdown

```
****
> 晓寻遥
> 
>> 所负责的内容为 <kbd>数据库</kbd> 和 <kbd>权限</kbd>的部分，所以属于我的文档也会比较多。
```markdown
> Service命名
>> ArticleService
>> ArticleTypeService
>> AssignmentService
>> CategoryService
>> CipherService
>> DiscussArticleService
>> GenreService
>> GitLogService
>> KeyService
>> LabelService
>> LikeService
>> NoticeService
>> PermissionService
>> RolePermissionService
>> RoleService
>> TopicKeyService
>> TopicLabelService
>> TopicService
>> UserRoleService
>> UserService
>> UserTopicService
```
```java
// 插入一条记录（选择字段，策略插入）
boolean save(T entity);
// 插入（批量）
boolean saveBatch(Collection<T> entityList);
// 插入（批量）
boolean saveBatch(Collection<T> entityList, int batchSize);
// TableId 注解存在更新记录，否插入一条记录
boolean saveOrUpdate(T entity);
// 批量修改插入
boolean saveOrUpdateBatch(Collection<T> entityList);
// 批量修改插入
boolean saveOrUpdateBatch(Collection<T> entityList, int batchSize);
// 根据 ID 删除
boolean removeById(Serializable id);
// 根据 columnMap 条件，删除记录
boolean removeByMap(Map<String, Object> columnMap);
// 删除（根据ID 批量删除）
boolean removeByIds(Collection<? extends Serializable> idList);
// 根据 ID 选择修改
boolean updateById(T entity);
// 根据ID 批量更新
boolean updateBatchById(Collection<T> entityList);
// 根据ID 批量更新
boolean updateBatchById(Collection<T> entityList, int batchSize);
// 根据 ID 查询
T getById(Serializable id);
// 查询所有
List<T> list();
// 查询（根据ID 批量查询）
Collection<T> listByIds(Collection<? extends Serializable> idList);
// 查询（根据 columnMap 条件）
Collection<T> listByMap(Map<String, Object> columnMap);
// 查询所有列表
List<Map<String, Object>> listMaps();
// 查询列表
List<Map<String, Object>> listMaps(Wrapper<T> queryWrapper);
// 查询全部记录
List<Object> listObjs();
// 查询全部记录
<V> List<V> listObjs(Function<? super Object, V> mapper);
// 无条件分页查询
IPage<T> page(IPage<T> page);
// 无条件分页查询
IPage<Map<String, Object>> pageMaps(IPage<T> page);
// 查询总记录数
int count();
```
```markdown
> Mapper命名
>> ArticleMapper
>> ArticleTypeMapper
>> AssignmentMapper
>> CategoryMapper
>> CipherMapper
>> DiscussArticleMapper
>> GenreMapper
>> GitLogMapper
>> KeyMapper
>> LabelMapper
>> LikeMapper
>> NoticeMapper
>> PermissionMapper
>> RoleMapper
>> RolePermissionMapper
>> TopicKeyMapper
>> TopicLabelMapper
>> TopicMapper
>> UserMapper
>> UserRoleMapper
>> UserTopicMapper
```
```java
// 插入一条记录
int insert(T entity);
// 删除（根据ID 批量删除）
int deleteBatchIds(@Param(Constants.COLLECTION) Collection<? extends Serializable> idList);
// 根据 ID 删除
int deleteById(Serializable id);
// 根据 columnMap 条件，删除记录
int deleteByMap(@Param(Constants.COLUMN_MAP) Map<String, Object> columnMap);
// 根据 ID 修改
int updateById(@Param(Constants.ENTITY) T entity);
// 根据 ID 查询
T selectById(Serializable id);
// 查询（根据 columnMap 条件）
List<T> selectByMap(@Param(Constants.COLUMN_MAP) Map<String, Object> columnMap);
// 查询（根据ID 批量查询）
List<T> selectBatchIds(@Param(Constants.COLLECTION) Collection<? extends Serializable> idList);
```