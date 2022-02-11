class Solution {
    public String largestNumber(int[] nums) {
        String[] ns = new String[nums.length];
        boolean hasNon0 = false;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0) hasNon0 = true;
            ns[i] = Integer.toString(nums[i]);
        }
        if(!hasNon0) return "0";
        Arrays.sort(ns, (a, b) -> -1 * a.concat(b).compareTo(b.concat(a)));
        return  String.join("", ns);
    }
    
}
