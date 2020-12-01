package adventofcode2019.day5;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Test;

class Day5Test {

    @Test
    void given_opcode_is_one_digit_getOpcode_returns_opcode_without_preceding_zero() {
        String expected_opcode = "2";
        assertThat(Day5.getOpcode("11002")).isEqualTo(expected_opcode);
        assertThat(Day5.getOpcode("1002")).isEqualTo(expected_opcode);
        assertThat(Day5.getOpcode("002")).isEqualTo(expected_opcode);
        assertThat(Day5.getOpcode("02")).isEqualTo(expected_opcode);
        assertThat(Day5.getOpcode("2")).isEqualTo(expected_opcode);
    }

    @Test
    void given_opcode_is_two_digits_getOpcode_returns_opcode() {
        String expected_opcode = "99";
        assertThat(Day5.getOpcode("11099")).isEqualTo(expected_opcode);
        assertThat(Day5.getOpcode("1099")).isEqualTo(expected_opcode);
        assertThat(Day5.getOpcode("099")).isEqualTo(expected_opcode);
        assertThat(Day5.getOpcode("99")).isEqualTo(expected_opcode);
    }

    @Test
    void given_parameters_getParameterMode_returns_parameter_map() {
        Map<Integer, Integer> parameters = Map.of(1, 1,
                2, 1,
                3, 1);
    }


}