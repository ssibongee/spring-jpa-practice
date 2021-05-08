## Spring Jpa Paging 학습을 위한 프로젝트 



<br>



### 페이징을 이용한 전체 목록 조회

아래와 같은 `URI`로 서버에 요청을 보내게되면 서버는 `URI`를 파싱하여 `Pageable` 인스턴스를 생성한다.
```markdown
http://localhost:8080/searches/page={pageNo}&size={size}
```

* `page` : 현재 페이지를 의미하며, 페이지는 0부터 시작한다.
* `size` : 한 페이지에 노출할 레코드의 건수를 의미한다.
* `sort` : 정렬 조건을 정의할 수 있으며 정렬 속성과 방향을 지정할 수 있다.

그리고 `ArticleRepository`의 `findAll(pageable)`을 통해 실제 JPA에 의해 생성되는 쿼리를 살펴보면 다음과 같다.

```sql
select
    article0_.article_id as article_1_0_,
    article0_.author as author2_0_,
    article0_.category as category3_0_,
    article0_.city as city4_0_,
    article0_.content as content5_0_,
    article0_.state as state6_0_,
    article0_.street as street7_0_,
    article0_.title as title8_0_ 
from
    article article0_ limit ?, ?
```

여기서 `limit` 을 살펴보면 처음 0번째 페이지를 조회하는 경우에는 `limit ?`와 같이 단순히 몇개의 레코드만 조회할 것인지를 나타내지만, 1번째 페이지부터는
`limit ?, ?`와 같이 사용되며 조회를 시작할 레코드부터 지정한 개수만큼 레코드를 조회한다.

그 다음 `List` 가 아닌 `Page` 객체로 반환하고 있기 때문에 개수를 카운트하기 위한 쿼리가 추가적으로 실행되는 것을 확인할 수 있다.

```sql
select
  count(article0_.article_id) as col_0_0_ 
from
  article article0_
```
