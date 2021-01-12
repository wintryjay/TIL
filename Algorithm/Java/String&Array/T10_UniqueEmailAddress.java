package Algorithm.Java.StringAndArray;

import java.util.HashSet;
import java.util.Set;

/*
# Question11. UniqueEmailAddress(Set, a.subString( , ))
    Eng: Every email consists of a local name and a domain name, separated by the @ sign.
         For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
         Besides lowercase letters, these emails may contain '.'s or '+'s.
         If you add periods ('.') between some characters in the local name part of an email address,
         mail sent there will be forwarded to the same address without dots in the local name.
         For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
         (Note that this rule does not apply for domain names.)
         If you add a plus ('+') in the local name, everything after the first plus sign will be ignored.
         This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.
         (Again, this rule does not apply for domain names.
         It is possible to use both of these rules at the same time.
         Given a list of emails, we send one email to each address in the list.
         How many different addresses actually receive mails?
    Kor: 모든 전자 메일은 로컬 이름과 도메인 이름으로 구성되며 @ 기호로 구분됩니다. 예를 들어 alice@leetcode.com에서 alice는 로컬 이름이고 leetcode.com은 도메인 이름입니다.
         소문자 외에도 이러한 전자 메일에는 '.s' 또는 '+'가 포함될 수 있습니다. 전자 메일 주소의 로컬 이름 부분에 있는 일부 문자 사이에 마침표('.')를 추가하면
         로컬 이름에 점이 없는 동일한 주소로 보낸 메일이 전달됩니다.
         예를 들어 "앨리스"입니다.z@leetcode.com" 및 "alicez@leetcode.com"은 동일한 이메일 주소로 전달됩니다.
         (이 규칙은 도메인 이름에는 적용되지 않습니다.)
         로컬 이름에 더하기('+')를 추가하면 첫 번째 더하기 기호 뒤의 모든 항목이 무시됩니다.
         이렇게 하면 특정 전자 메일을 필터링할 수 있습니다. 예를 들어 m.y+name@email.com이 my@email.com으로 전달됩니다.
         (또한 이 규칙은 도메인 이름에는 적용되지 않습니다.)
         이 두 가지 규칙을 동시에 사용할 수 있습니다.
         전자 메일 목록이 주어지면 목록의 각 주소로 하나의 전자 메일을 보냅니다. 실제로 메일을 받는 주소가 몇 개인가?

    input: ["test.email+jame@coding.com","test.e.mail+toto.jane@coding.com","testemail.tom@cod.ing.com"]
    output: 2
 */
public class T10_UniqueEmailAddress {

    public static void main(String[] args) {
        T10_UniqueEmailAddress a = new T10_UniqueEmailAddress();
        String[] emails = {"test.email+jame@coding.com",
                           "test.e.mail+toto.jane@coding.com",
                           "testemail.tom@cod.ing.com"};
        System.out.println(a.numUniqueEmails(emails));
    }

    public int numUniqueEmails(String[] emails) {
        // 1.
        Set<String> set = new HashSet<>();

        // 2.
        for(String email: emails) {
            String localName = makeLocalName(email); // testemail
            String domainName = makeDomainName(email); // @ 이후에 첫자로 시작하는 애들 모으기.

            set.add(localName+"@"+domainName);
        }

        return set.size();
    }

    private  String makeDomainName(String email) {
        return email.substring(email.indexOf('@')+1);
    }

    private String makeLocalName(String email) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<email.length(); i++) {
            // 1. Error Check
            if(email.charAt(i)=='.') {
                continue;
            }
            if(email.charAt(i)=='+') {
                break;
            }
            if(email.charAt(i)=='@') {
                break;
            }

            // 2.
            String str = String.valueOf(email.charAt(i));
            sb.append(str);
        }
        return sb.toString();
    }

}
