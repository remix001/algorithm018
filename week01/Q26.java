public class Q26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
    
            if (nums[j] != nums[i]) {
                //System.out.println(i+","+j);
                i++;
                //System.out.println(i+","+j);
                nums[i] = nums[j];
            }
        }
        //System.out.println(i);
        return i + 1;
        }
}
