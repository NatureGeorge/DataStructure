# Wiki of Data Structures

> Modified By ZeFeng Zhu 2019-10-13

[toc]

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

#### Boyer-Moore算法

(...)

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
