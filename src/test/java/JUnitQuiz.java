import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JUnitQuiz {

    @Test
    public void junitQuiz() {
            String name1 = "홍길동";
            String name2 = "홍길동";
            String name3 = "홍길금";
            //null이 아닌지
        assertThat(name1).isNotNull();
        //name1 name2가 같은지
        assertThat(name1).isEqualTo(name2);
        //name1 name3가 다른지
        assertThat(name1).isNotEqualTo(name3);
    }
    @Test
    public void junitQuiz2() {
        int n1=15;
        int n2=0;
        int n3=-5;
        // n1 양수인지
        assertThat(n1).isPositive();
        //n3가 음수인지
        assertThat(n3).isNegative();
        // n1이 n2 보다 큰지 확인
        assertThat(n1).isGreaterThan(n2);

        //n3가 n2보다 작은지
        assertThat(n3).isLessThan(n2);
    }

}
