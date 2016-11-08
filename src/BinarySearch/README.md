#MyLeetCode-BinarySearch

##定义
* 【Wiki】
> Binary search works on sorted arrays.
A binary search begins by comparing the middle element of the array with the target value.
If the target value matches the middle element, its position in the array is returned.
If the target value is less than or greater than the middle element, the search continues in the lower or upper half of the array, respectively, eliminating the other half from consideration

* 【百度】
> 首先将给定值key与字典中间位置上元素的关键码(key)比较，如果相等，则检索成功；
否则，若key小，则在字典前半部分中继续进行二分法检索;
若key大，则在字典后半部分中继续进行二分法检索。
这样，经过一次比较就缩小一半的检索区间，如此进行下去，直到检索成功或检索失败。
偶数个取中间2个其中任何一个作为中间元素

##实现方式
BinarySearch最常用的2种实现方式
* 递归
* 循环
