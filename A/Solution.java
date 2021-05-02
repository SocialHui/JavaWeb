class Solution {
    //归并排序
/**
 *     *
 *      * 一个是分解的过程，一个是合并的过程
 *      * @param array
 *
 */

    public void sort (int[] array) {
        fenJie(array,0,array.length-1);
    }

    public void fenJie(int[] array, int left, int right) {
        if (left == right) {
            return;
        }
        //分解
        int mid = (left+right)/2;
        fenJie(array,left,mid);
        fenJie(array,mid+1, right);
        heBing(array,left,mid,right);
    }

    //合并
    public void heBing(int[] array, int start, int mid, int end) {
        int[] tmp = new int[end-start+1];
        int s1 = start;
        int e1 = mid;
        int s2 = mid+1;
        int e2 = end;
        int i = 0;
        while (s1 <= e1 && s2 <= e2) {
            if (array[s1] < array[s2]) {
                tmp[i++] = array[s1++];
            } else {
                tmp[i++] = array[s2++];
            }
        }
        while (s1 <= e1) {
            tmp[i++] = array[s1++];
        }
        while (s2 <= e2) {
            tmp[i++] = array[s2++];
        }
        //注意
        for (int j = 0; j < tmp.length; j++) {
            array[start++] = tmp[j];
        }
    }
}

