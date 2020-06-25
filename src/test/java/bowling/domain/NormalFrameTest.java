package bowling.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("NormalFrame 클래스 테스트")
public class NormalFrameTest {

    @DisplayName("볼링 결과를 갖는다.")
    @Test
    void bowl() {
        NormalFrame normalFrame = new NormalFrame();
        normalFrame.bowl(new Pin(10));

        assertThat(normalFrame.getStates().getStates().get(0)).isEqualTo(State.STRIKE);
        assertThat(normalFrame.getPin()).isEqualTo(new Pin(10));
    }


    @DisplayName("현재 프레임 종료 여부를 반환할 수 있다.")
    @Test
    void isEndFrame() {
        NormalFrame normalFrame = new NormalFrame();
        normalFrame.bowl(new Pin(10));

        boolean actual = normalFrame.isEndFrame();

        assertThat(actual).isTrue();
    }
}
