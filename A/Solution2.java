public class Solution2 {
    //递归排序的非递归版本
    public void sort(int[] array){
        for (int i = 1; i < array.length; i*=2) {
            mergeSort(array,i);
        }
    }

    public void mergeSort(int[] array, int gap) {
        int s1 = 0;
        int e1 = s1+gap-1;
        int s2 = e1 + 1;
        int e2 = s2+gap-1 < array.length ? s2+gap-1 : array.length-1;
        int[] tmp = new int[array.length];
        int k = 0;

        //执行这个while语句代表有两个归并段
        while (s2 < array.length) {
            while (s1 <= e1 && s2 <= e2) {
                if (array[s1] <= array[s2]) {
                    tmp[k++] = array[s1++];
                } else {
                    tmp[k++] = array[s2++];
                }
            }
            while (s1 <= e1) {
                tmp[k++] = array[s1++];
            }
            while (s2 <= e2) {
                tmp[k++] = array[s2++];
            }
            s1 = e2+1;
            e1 = s1+gap-1;
            s2 = e1 + 1;
            e2 = s2+gap-1 < array.length ? s2+gap-1 : array.length-1;
        }

        while (s1 < array.length) {
            tmp[k++] = array[s1++];
        }

        for (int i = 0; i < tmp.length; i++) {
            array[i] = tmp[i];
        }
    }
}
