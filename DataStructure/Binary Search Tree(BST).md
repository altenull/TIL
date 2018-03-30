# Binary Search Tree(BST)

## 트리(Tree)
- 스택, 큐와 같은 선형이 아닌 비선형 자료구조
- 계층적 관계(Hierarchical Relationship)를 표현
- 트리는 노드(Node)들의 구성체
- 트리에서는 각 층별로 숫자를 매겨서 이를 트리의 레벨(Level)이라고 표현
- 루트 노드의 레벨은 0
- 트리의 최고 레벨을 가리켜 해당 트리의 높이(Height)라고 함

**구성요소**
- 노드(Node) : 트리를 구성하고 있는 각각의 요소로서 노드는 3개의 멤버를 가짐(Value, Left, Right)
- 간선(Edge) : 노드와 노드를 연결하는 선
- 루트 노드(Root Node) : 트리 구조에서 최상위에 있는 노드
- 단말 노드(Terminal Node, Leaf Node) : 자식 노드가 없는 노드
- 비단말 노드(Internal Node) : 단말 노드를 제외한 모든 노드로 루트 노드도 포함

## 이진 트리(Binary Tree)

- 루트 노드를 중심으로 두 개의 서브 트리로 나뉘어 짐
- 나뉘어진 두 서브 트리도 모두 이진 트리어야 함

**포화 이진 트리(Full Binary Tree), 완전 이진 트리(Complete Binary Tree)**

- 모든 레벨이 꽉 찬 이진 트리를 **포화 이진 트리**라고 함
- 위에서 아래로, 왼쪽에서 오른쪽으로 순서대로 차곡차곡 채워진 트리를 **완전 이진 트리**라고 함


## Binary Search Tree(BST)

- 이진 탐색 트리의 노드에 저장된 키는 유일함
- 루트 노드의 키가 왼쪽 서브 트리를 구성하는 어떠한 노드의 키보다 큼
- 루트 노드의 키가 오른쪽 서브 트리를 구성하는 어떠한 노드의 키보다 작음
- 왼쪽과 오른쪽 서브트리도 이진 탐색 트리
- 퍼포먼스 좋음(검색, 삽입, 삭제 `O(log n)`)

### 삽입

<p align='center'><img src='https://s3.ap-northeast-2.amazonaws.com/altenull/github/TIL/DataStructure/BST+insert.png' /></p>

루트 노드부터 시작하며 삽입하려는 키값이 노드의 값보다 작으면 왼쪽 서브트리로 크면 오른쪽 서브트리로 내려가며 이동

### 삭제

<p align='center'><img src='https://s3.ap-northeast-2.amazonaws.com/altenull/github/TIL/DataStructure/BST+delete.jpg' /></p>

**삭제하는 노드의 3가지 경우**
1. 자식이 없을 때 -> 해당 노드 바로 삭제

2. 자식이 하나 있을 때 -> 해당 노드를 삭제하고, 삭제한 자리에 자식노드를 붙임

3. 자식이 둘 있을 때 -> 오른쪽 서브트리 중 가장 왼쪽인 노드를 삭제한 자리에 붙임

### Traverse(순회)

<p align='center'><img src='https://s3.ap-northeast-2.amazonaws.com/altenull/github/TIL/DataStructure/BST+travelers.png' /></p>

**pre-order**
1. 루트 방문
2. 왼쪽 서브트리 방문
3. 오른쪽 서브트리 방문

**post-order**
1. 왼쪽 서브트리 방문
2. 오른쪽 서브트리 방문
3. 루트 방문

**in-order**
1. 왼쪽 서브트리 방문
2. 루트 방문
3. 오른쪽 서브트리 방문

in-order 특징 : 순회를 하고 나면, 가장 작은값부터 큰값으로 정렬됨`O(n)`