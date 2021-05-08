> This is the 2019 open source project of Hangzhou Vocational and Technical College of Science and Technology

## Document directory
```markdown
> [hzpt-controller](The control layer is used to control the calls of the API interface and the service layer)
> [hzpt-jurisdiction](Permission layer, used to control the use and deployment of permissions)
> [hzpt-mapper](Persistence layer, one-to-one correspondence with the database)
> ......
```

## Author Directory
```markdown
> []()
> [Xiao Xunyao](https://github.com/xiaoxunyao)
> []()
> []()
> []()
> []()
> [Annnnnnovice](https://github.com/Annnnnnovice)
> []()
> [user-mrj](https://github.com/user-mrj)
```

## Project directory
****
>
```markdown

```
****
> Xiao XunYao
>> Responsible for the content of the <kbd>database</kbd> and <kbd>permissions</kbd>, so there will be more documents belonging to me.
```markdown
> Service naming
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
// Insert a record (select field, strategy insert)
boolean save(T entity);
// Insert (bulk)
boolean saveBatch(Collection<T> entityList);
// Insert (bulk)
boolean saveBatch(Collection<T> entityList, int batchSize);
// TableId annotation has update records, whether to insert a record
boolean saveOrUpdate(T entity);
// Batch edit and insert
boolean saveOrUpdateBatch(Collection<T> entityList);
// Batch edit and insert
boolean saveOrUpdateBatch(Collection<T> entityList, int batchSize);
// Delete based on ID
boolean removeById(Serializable id);
// According to columnMap conditions, delete records
boolean removeByMap(Map<String, Object> columnMap);
// Delete (delete in batches based on ID)
boolean removeByIds(Collection<? extends Serializable> idList);
// Select edit based on ID
boolean updateById(T entity);
// Batch update based on ID
boolean updateBatchById(Collection<T> entityList);
// Batch update based on ID
boolean updateBatchById(Collection<T> entityList, int batchSize);
// Query by ID
T getById(Serializable id);
// Query all
List<T> list();
// Query (Batch query based on ID)
Collection<T> listByIds(Collection<? extends Serializable> idList);
// Query (according to columnMap conditions)
Collection<T> listByMap(Map<String, Object> columnMap);
// Query all lists
List<Map<String, Object>> listMaps();
// Query list
List<Map<String, Object>> listMaps(Wrapper<T> queryWrapper);
// Query all records
List<Object> listObjs();
// Query all records
<V> List<V> listObjs(Function<? super Object, V> mapper);
// Unconditional pagination query
IPage<T> page(IPage<T> page);
// Unconditional pagination query
IPage<Map<String, Object>> pageMaps(IPage<T> page);
// Query the total number of records
int count();
```
```markdown
> Mapper naming
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
// Insert a record
int insert(T entity);
// Delete (delete in batches based on ID)
int deleteBatchIds(@Param(Constants.COLLECTION) Collection<? extends Serializable> idList);
// Delete based on ID
int deleteById(Serializable id);
// According to columnMap conditions, delete records
int deleteByMap(@Param(Constants.COLUMN_MAP) Map<String, Object> columnMap);
// Modify according to ID
int updateById(@Param(Constants.ENTITY) T entity);
// Query by ID
T selectById(Serializable id);
// Query (according to columnMap conditions)
List<T> selectByMap(@Param(Constants.COLUMN_MAP) Map<String, Object> columnMap);
// Query (Batch query based on ID)
List<T> selectBatchIds(@Param(Constants.COLLECTION) Collection<? extends Serializable> idList);
```