class LongestCommonPrefix {

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * 示例 1:
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     *
     * 示例 2:
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     *
     * 说明:
     * 所有输入只包含小写字母 a-z 。
     */
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) {
            return "";
        }
        if (len == 1) {
            return strs[0];
        }
        String tmp = help(strs[0], strs[1]);
        if (tmp == null) {
            return "";
        }
        for (int i = 2; i < len; i ++) {
            tmp = help(tmp, strs[i]);
            if (tmp == null) {
                return "";
            }
        }
        return tmp;
    }

    private String help(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());
        for (int i = len; i > 0; i --) {
            String s = s1.substring(0, i);
            if (s.equals(s2.substring(0, i))) {
                return s;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LongestCommonPrefix l = new LongestCommonPrefix();
        System.out.println(l.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(l.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
}