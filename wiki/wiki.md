# Wiki of Data Structures🐱‍👤

```txt
Created Date: Wednesday, November 27th 2019, 8:12:28 am
Author: ZeFeng Zhu🤔
```

## Solving problems: from problem to program

### Main step

1. 确定问题求解的数学模型或逻辑结构
   * 对问题进行深入分析，确定处理的数据对象是什么
   * 再考虑处理对象的逻辑关系给出其数学模型
2. 确定存储结构
   * 根据数据对象的逻辑结构及其所需完成的功能，选择一种合适的组织形式将数据映射到计算机的存储器中
3. 设计算法
   * 讨论要解决的问题的策略，即算法的具体步骤
4. 编程并测试结果
   * 根据算法编写程序并上机测试，直到问题最终解决

### Essense of programming

1. 根据实际问题选择一种好的数据结构
2. 设计一个好的算法
3. 2的好坏很大程度上取决于1

### Examples

最小生成树:

```viz
graph MGT {
    edge [color="0.700 0.200 1.000"];
    # graph [bgcolor="0.6 0.6 0.6"];
    size="5,5";
    ratio = 1.4;
    node [style=filled, color="0.650 0.200 1.000"];
    A--B[label="1" color="pink"];
    A--C[label="2" color="pink"];
    A--D[label="4" color="pink"];
    A--E[label="6"];
    # B--C[label="5"];
    B--D[label="9"];
    B--E[label="7"];
    C--D[label="10"];
    C--E[label="8"];
    D--E[label="3" color="pink"];
    overlap=false;
}
```

## Basic Concepts

### About Data

* Data
  * 数据是信息的载体，是对客观事物的符号表示，能够被计算机程序识别、存储、加工和处理
  * 是所有能够有效地输入到计算机中并且能够被计算机处理的符号的总称
  * 是计算机程序处理对象的集合
* Data Element/Node/Vertex/Record
  * 是数据的基本组织单位
* Data Item (Component of Data Element)
  * 是数据元素的组成部分
* Data Object
  * 是性质相同的数据元素的集合
* Data Structure
  * 相互之间存在一种或多种特定关系的数据元素的集合
  * 考虑 (下面三者当中任何一个不同都将导致不同的数据结构，当三个方面内容都相同，两数据结构才完全相同)
    * 数据的逻辑结构
    * 数据的存储结构
    * 数据的操作

#### 数据的逻辑结构

##### 集合

```viz
graph set {
    edge [color="0.700 0.200 1.000"];
    node [style=filled, color="0.650 0.200 1.000"]; A;B;C;D
    overlap=false;
}
```

##### 线性结构

```viz
graph linear {
    graph [rankdir = "LR"];
    edge [color="0.700 0.200 1.000"];
    node [style=filled, color="0.650 0.200 1.000"];
    overlap=false;
    A--B;
    B--C;
    C--D;
}
```

##### 树形结构

```viz
graph tree {
    edge [color="0.700 0.200 1.000"];
    node [style=filled, color="0.650 0.200 1.000"];
    overlap=false;
    A--B;
    A--C;
    A--D;
    B--E;
    B--F;
    C--G;
    D--H;
    D--I;
    D--J;
}
```

##### 图形结构

```viz
graph Gra {
    ratio = 0.7;
    edge [color="0.700 0.200 1.000"];
    node [style=filled, color="0.650 0.200 1.000"];
    overlap=false;
    A--B;
    A--C;
    A--D;
    B--C;
    B--D;
}
```

#### 数据的存储结构

* 顺序存储
* 链式存储
* 索引存储
* 散列存储

#### 数据的操作

##### 常用操作

* 创建
* 销毁
* 插入
* 删除
* 查找
* 修改
* 遍历

### About Algorithm

#### Property

1. 有穷性
2. 确定性
3. 有效性
4. 输入
5. 输出

#### Consideration

1. 正确性
2. 可读性
3. 健壮性
4. 高效率

#### Analysis of Algorithm

* 算法的时间复杂度分析
* 最好、最坏与平均时间复杂度
* 算法按时间复杂度分类
* 算法空间复杂度分析

#### Examples

...

## 串与数组

### 串的概念

$$s = "c_{0}c_{1}c_{2}...c_{ci}...c_{n-1}"$$

### 串的模式匹配

#### Brute-Force算法

> 一种在实践中颇为有效的，暴力/朴素/简单直观的算法。

```java
// haystack: 主串, needle: 子串

public int index_BruteForce(String haystack, String needle, int start){
  // 检查子串合理性
  if(needle != null && needle.length()>0 && haystack.length() >= needle.length()){
    int j = 0;
    int hs_len = haystack.length();
    int nd_len = needle.length();
    //遍历主串,匹配上子串的部分随循环更替
    while((start < hs_len) && (j < nd_len)){
      //延长匹配上的部分
      if(haystack.charAt(start) == needle.charAt(j)){
        start++;
        j++;
      }
      //一旦有非匹配字符,将主串遍历位置回退至最初匹配上的index之后一位,并将匹配上的长度归零
      else{
        start = start - j + 1;
        j = 0;
      }
    /*循环结束,判断主串匹配上的子串部分的合理性
      循环结束条件:
      * 主串遍历完 或
      * 子串已遍历完
    */
    }
    // 子串完整匹配上
    if (j >= nd_len){
      return start - nd_len;
    }
    // 子串不完整匹配或子串未匹配上
    else{
      return -1;
    }
  }
  /* 子串不合理
  * null 或
  * 空串
  * 比主串短
  */
  return -1;
}
```

#### Knuth-Morris-Pratt算法

```java
public int[] KMP(String haystack, String needle) {
  int text_len = haystack.length()
  int needle_len = needle.length();
  int[] pi = getNextVal(needle);
  int q = 0;
  int[] result = new int[(int)(text_len / needle.length())];
  int count = 0;

      for (int i = 0; i < text_len; i++) {
          while (q > 0 && haystack.charAt(i) != needle.charAt(q)) {
              q = pi[q - 1];
          }

          if (haystack.charAt(i) == needle.charAt(q)) {
              q++;
          }

          if (q == needle_len) {
            result[count] = i + 1 - needle_len;
            count += 1;
            q = pi[q - 1];
          }
      }

      if (count == 0) {
        result = new int[1];
        result[0] = -1;
        return result;
      }
      else {
        return result;
      }
}

public int[] getNextVal(String str) {
  int n = str.length();
  int[] pi = new int[n];
  pi[0] = 0;
  int q = 0;
  for (int i = 1; i < n; i++) {
      while (q > 0 && str.charAt(q) != str.charAt(i)) {
          q = pi[q - 1];
      }
      if (str.charAt(q) == str.charAt(i)) {
          q++;
      }
      pi[i] = q;
  }
  return pi;
}
```

* [📺 KMP Algorithm | Searching for Patterns | GeeksforGeeks](https://www.youtube.com/watch?v=cH-5KcgUcOE)
* Longest Proper Prefix, which is also suffix
* Preprocessing
  * only need PATTERN and alphabet
* Then searching the pattern
  * Not match character that we know will anyway match

#### Boyer-Moore

> Naive exact matching -> Boyer-Moore Algorithm[📺](https://www.youtube.com/watch?v=4Xyhb72LCX4)

* Learn from character comparisons to skip pointless alignments
* Try alignments in left-to-right order, and try character comparisons in right-to-left order
* Bad Character Rule (turn a mismatch into a match)
  * skip alignments until a mismatch becomes match
  * or PATTERN moves past mismatched character
* Good Suffix Rule (keep the matches matches and not have to turn them into mismatches) 
  * let t=substring matched by inner loop
  * skip until
    * there are no mismatches between PATTERN and t
    * or PATTERN moves past t
* Putting two rules together
  * whichever skips more
* Preprocessing
  * Only need PATTERN and alphabet

##### Example of Preprocessing

* `PATTERN="TCGC"`
* `alphabet={"A", "T", "C", "G"}`

table: (the number in the table represent the number of alignments that we can skip)

| |T|C|G|C|
|---|---|---|---|---|
|A  |(bc: 0, gs: )  |(bc: 1, gs: )  |(bc: 2, gs: 1) |(bc: 3, gs: 0) |
|C  |(bc: 0, gs: )  |-  |(bc: 0, gs: 1) |- |
|G  |(bc: 0, gs: )  |(bc: 1, gs: )  |-  |(bc: 0, gs: 0) |
|T  |-  |(bc: 0, gs: )  |(bc: 1, gs: 1)  |(bc: 2, gs: 0) |

##### Code Example

[📺 ADS1: Practical: Implementing Boyer-Moore](https://www.youtube.com/watch?v=CT1lQN73UMs)

#### 可视化演示

* http://whocouldthat.be/visualizing-string-matching/

### 串的应用

#### 文本文件加密

* a:原码
* k:密钥
* b:密码
* $\wedge$:异或运算

$a$|$b$|$a \wedge b$
-|-|-
1|1|0
1|0|1
0|1|1
0|0|0

> 相同为0 $\rightarrow$ 连续两次与同一数字进行运算，结果保持原样

$$b = a \wedge k \Rightarrow a = b \wedge k$$
$$a \wedge k \wedge k = a \wedge (k \wedge k) = a \wedge 0 = a$$

```java
//加密
char a = s.charAt(i);
int k = ((int) Math.sqrt(key)) % 126 + 1;
int b = a^k;
char char_b = (char) b;
//解密
int aa = char_b^k;
char char_aa = (char) aa;
```

### 数组的概念

$$A_{x\times y \times z \times ...}$$

### 数组的顺序存储

对于一维数组:

* $n$个元素
* $L$:每个元素的占用字节大小
* $Loc(0)$:首地址

$$Loc(i) = Loc(0) + i \times L \quad (0\le i \lt n)$$

对于二维数组:

* $n \times m$个元素
* $L$:每个元素的占用字节大小
* $Loc(0, 0)$:首地址

$$Loc(i,j) = Loc(0,0) + (i \times m + j) \times L \quad (0\le i \le n-1, 0\le j \le m-1)$$

一般情况:

* n维数组: $A[m_1][m_2]...[m_n]$
* 数据元素: $a[i_1][i_2]...[i_n]$

$$Loc(i_1,i_2,...,i_n) = Loc(0,0,...,0) + (i_1 \times m_2 \times ... \times m_n + i_2 \times m_3 \times ... \times m_n + ... + i_{n-1} \times m_n + i_n) \times L$$
$$\Downarrow$$
$$Loc(i_1,i_2,...,i_n) = Loc(0,0,...,0) + (\sum^{n-1}_{j=1}i_j \prod_{k=j+1}^{n}m_k + i_n) \times L$$

### 特殊数组的压缩存储

#### 对称矩阵

* 二维矩阵
* n阶方阵A中元素满足:

$$a_{ij} = a_{ji} \quad (0\le i, j \le n-1)$$

* 将$n \times n$个元素压缩至$\dfrac{n(n+1)}{2}$个元素的存储空间 (@等差数列求和公式)
* 可按优先顺序存储 (@等差数列求和公式):
  * $S[\frac{n(n+1)}{2}]$
  * $A[i][j] = S[k]$:

$$ k = \begin{cases}
    \dfrac{i(i+1)}{2} + j \quad & (i \ge j) \\\\
    \dfrac{j(j+1)}{2} + i \quad & (i \lt j)
    \end{cases}
$$

* 示例:
  * $a_1 = 1 ,\, a_n = n \Rightarrow S_n = \frac{n(n+1)}{2}$
  * $A[2][1] \Rightarrow skip\{(0,0)(1,0)(1,1)\} \leftrightarrow skip\{S_2=\frac{2(2+1)}{2}\} \Rightarrow skip\{(2,0)\} \leftrightarrow skip\{j=1\} \Rightarrow (2,1)$

```latex
A:
(0,0)
(1,0) (1,1)
(2,0) (2,1) (2,2)
(3,0) (3,1) (3,2) (3,3)
....................................
S:
(0,0)..(1,0) (1,1)..(2,0) (2,1) (2,2)..(3,0) (3,1) (3,2) (3,3)...
```

#### 三角矩阵

> 对称矩阵的特例

* 二维矩阵
* $n$阶方阵
* 上三角or下三角
* 将$n \times n$个元素压缩至$\dfrac{n(n+1)}{2}$个元素的存储空间 (@等差数列求和公式)
* 可按优先顺序存储 (@等差数列求和公式):
  * $S[\frac{n(n+1)}{2}]$
  * $A[i][j] = S[k]$:
    * 下三角:

$$ k = \begin{cases}
    \dfrac{i(i+1)}{2} + j \quad & (i \ge j) \\\\
    null \quad & (i \lt j)
    \end{cases}
$$
    * 上三角:
$$ k = \begin{cases}
    null \quad & (i \gt j) \\\\
    \dfrac{j(j+1)}{2} + i \quad & (i \le j)
    \end{cases}
$$

#### 对角矩阵

* 二维矩阵
* $n$阶方阵
* $n$阶$2d+1$对角矩阵:
  * 所有非零元素集中于以主对角线为中心的带状区域内
  * 形成半宽带为d的带状矩阵,带宽为$2d+1$
  * $2d+1 \le n \Leftrightarrow d \le \frac{n-1}{2}$  ?
* 将$n \times n$个元素压缩至$n(2d+1)-d(d+1)$个元素的存储空间
  * 例: $n=7,\,d=3$:

$$
A =
\begin{bmatrix}
a_{00} & a_{01} & a_{02} & a_{03}  & 0 & 0 & 0    \\
a_{10} & a_{11} & a_{12} & a_{13}  & a_{14} & 0 & 0    \\
a_{20} & a_{21} & a_{22} & a_{23}  & a_{24} & a_{25} & 0    \\
a_{30} & a_{31} & a_{32} & a_{33}  & a_{34} & a_{35} & a_{36}    \\
0 & a_{41} & a_{42} & a_{43}  & a_{44} & a_{45} & a_{46}    \\
0 & 0 & a_{52} & a_{53}  & a_{54} & a_{55} & a_{56}    \\
0 & 0 & 0 & a_{63} & a_{64} & a_{65} & a_{66}    \\
\end{bmatrix}
$$
  * 例: $n=7,\,d=2$:
$$
A =
\begin{bmatrix}
a_{00} & a_{01} & a_{02} & 0.  & 0. & 0 & 0    \\
a_{10} & a_{11} & a_{12} & a_{13}  & 0. & 0 & 0    \\
a_{20} & a_{21} & a_{22} & a_{23}  & a_{24} & 0 & 0    \\
0 & a_{31} & a_{32} & a_{33}  & a_{34} & a_{35} & 0    \\
0 & 0 & a_{42} & a_{43}  & a_{44} & a_{45} & a_{46}    \\
0 & 0 & 0. & a_{53}  & a_{54} & a_{55} & a_{56}    \\
0 & 0 & 0. & 0. & a_{64} & a_{65} & a_{66}    \\
\end{bmatrix}
$$
  * $\text{count}(\text{zero in first 2d+1}) = \frac{d(d+1)}{2} \times 2 = d(d+1), \qquad S_n = na_1 + \frac{n(n-1)d}{2}$)

### 稀疏矩阵的压缩存储

#### 三元组表存储

#### 十字链表存储

### 数组的应用

#### n阶魔方阵

## 二叉树🌲

### 二叉树的性质

1. 二叉树中第$i \, (i \ge 0)$层上的结点数最多为2;
   * 数学归纳法证明
2. 深度为$h \, (h \ge 1)$ 的二叉树最多有$2^h-1$个结点;
   * 等比数列求和: $2^0+2^1+2^2+...+2^{h-1}=2^h-1$
3. 对于任意一棵二叉树，若其叶结点的个数为$n_0$, 度为2的结点个数为$n_2$, 则有$n_0=n_2+1$
   * 结点数满足关系: $n=n_0+n_1+n_2 \, (\text{n:二叉树总节点数; n1:度为1的结点总数})$
   * 边满足关系: $e=n_1+2*n_2$
   * 结点与边的关系: $n=e+1$
   * $n_0+n_1+n_2=n_1+2*n_2+1 \Rightarrow n_0=n_2+1$
4. 具有n个结点的完全二叉树，其深度为$\lfloor log_2n\rfloor+1 \quad \text{or} \quad \lceil log_2(n+1)\rceil$
   * 可由性质2推导得出
   * $log_2n\lt h\le log_2n+1$
5. 对于具有n个结点的完全二叉树，若从根结点开始自上而下并且按照层次由左向右对结点从0开始编号，则对于任意一个编号为$i \, (0\le i \lt n)$的结点有:
   1. 若$i=0$，则编号i的结点是二叉树的根节点，没有双亲；若i>1，则编号为i的结点其双亲编号为$\lfloor(i-1)/2\rfloor$
   2. 若$2i+1\ge n$，则编号为i的结点无左孩子，否则编号为$2i+1$的结点就是其左孩子
   3. 若$2i+2\ge n$，则编号为i的结点无右孩子，否则编号为$2i+2$的结点就是其右孩子


## Deterministic Finite Automata

* [📺 How to design a DFA 1, Neso Academy](https://www.youtube.com/watch?v=40i4PKpM0cI)
* [📺 How to design a DFA 2, Neso Academy](https://www.youtube.com/watch?v=2KindKcLjos)
* [📺 How to design a DFA 3, Neso Academy](https://www.youtube.com/watch?v=_2cKtLkdwnc)
  * i.e Filp the states
* [📺 How to figure out what a DFA rcognizes, Neso Academy](https://www.youtube.com/watch?v=Fpmr1nHqYrw)

## Expectation Maximization Algorithm

* [📺 EM algorithm: how it works](https://www.youtube.com/watch?v=REypj2sy_5U)

### Note

* Application of Bayes Formula
* Need to know the parameters of the distribution