# BEM

> BEM — Block Element Modifier is a methodology that helps you to create reusable components and code sharing in front-end development

### BEM is CSS naming convention

**B**lock

**E**lement

**M**odifier

- block은 높은 단계의 구성요소를 말함.
- block__element는 .block의 자식을 말함.
- block--modifier는 .blcok의 다른 상태나 버전을 말함.

**간단한 예**

``` css
.block
.block__element{}
.block--modifier{}
```

**조금 더 자세히**

``` css
.person {}
.person__hand {}
.person--female {}
.person--femail__hand {}
.person__hand--left {}
```

**여러 단어의 조합을 표현하려면?**

하이픈(-) 1개만 사용!

``` css
.line-graph {}
.line-graph__xAxis {}
.line-graph__line1 {}
.line-graph__line2--show {}
.line-graph__line2--hide {}
.line-graph__short-line3--show {}
```