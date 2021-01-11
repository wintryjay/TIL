package Algorithm.Java.StringAndArray;
/*
# Question08. LicenseKeyFormatting(StringBuilder, Replace,
    Eng: You are given a license key represented as a string S which consists only alphanumeric character and dashes.
         The string is separated into N+1 groups by N dashes.
         Given a number K, we would want to reformat the strings such that each group contains exactly K characters,
         except for the first group which could be shorter than K, but still must contain at least one character.
         Furthermore, there must be a dash inserted between two groups and all lowercase letters should be converted to
         uppercase.
         Given a non-empty string S and a number K, format the string according to the rules described above.
    Kor: 영숫자와 대시로만 구성된 문자열 S로 표시된 라이센스 키가 제공됩니다. 문자열은 N 대시로 N+1 그룹으로 구분됩니다.
         숫자 K가 주어지면, 우리는 K보다 작을 수 있지만 적어도 하나의 문자를 포함해야 하는 첫 번째 그룹을 제외하고 각 그룹에
         K 문자가 정확히 포함되도록 문자열을 다시 포맷하고자 합니다. 또한 두 그룹 사이에 대시를 삽입해야 하며 모든 소문자는 대문자로 변환해야 합니다.
         비어 있지 않은 문자열 S와 숫자 K가 주어지면 위에서 설명한 규칙에 따라 문자열의 형식을 지정합니다.

    input: String str = "8F3Z-2e-9-w"
           String str = "8-5g-3-J"
           int k = 4;
    output: 8F3Z-2E9W 8F3Z-2E9W, 8-5G3J

    1. 하이픈 제거, 대문자 변환
    2. 끝에서 4자리씩 끊기

 */
public class T07_LicenseKeyFormatting {

    public static void main(String[] args) {
        String str = "8F3Z-2e-9-weraafc";
//        String str2 = "8-5g-3-J";
        int k = 4;
        System.out.println(solve(str, k));

    }

    public static String solve(String str, int k) {
        String newStr = str.replace("-","");
//        System.out.println("newStr :"+newStr);

        String upperStr = newStr.toUpperCase();
//        System.out.println("upperStr :"+upperStr);

        int leng = upperStr.length();
//        System.out.println("leng :" +leng);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<leng; i++) {
            sb.append(upperStr.charAt(i));
        }
//        System.out.println("sb : "+sb);

        for(int i=k; i<leng; i=i+k) {
//            System.out.println("leng-i :"+(leng-i));
            sb.insert(leng-i,'-');
        }
//        System.out.println("--sb : "+sb);
        return sb.toString();
    }
}
