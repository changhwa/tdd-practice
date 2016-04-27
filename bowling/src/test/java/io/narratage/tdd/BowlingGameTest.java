package io.narratage.tdd;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

public class BowlingGameTest {

    private BowlingGame bowlingGame;

    @Before
    public void setUp() {
        bowlingGame = new BowlingGame();
    }

    @Test
    public void test_bowling_game_create() {
        assertThat(bowlingGame, notNullValue());
    }

    @Test
    public void all_gutter() {

        int bowls = 20;
        int pins = 0;

        bowlRepeat(bowls, pins);
        assertThat(bowlingGame.getScore(), is(0));
    }

    @Test
    public void all_strike() {

        bowlRepeat(12, 10);

        assertThat(bowlingGame.getScore(), is(300));
    }

    @Test
    public void one_stike_and_all_gutter() {

        bowlingGame.bowl(10);
        bowlRepeat(18, 0);

        assertThat(bowlingGame.getScore(), is(10));
    }

    @Test
    public void one_strike_and_seven_score_and_all_gutter() {

        //when
        bowlingGame.bowl(10);
        bowlingGame.bowl(7);
        bowlRepeat(17, 0);

        //then
        assertThat(bowlingGame.getScore(), is(24));
    }

    @Test
    public void nine_score_and_one_strike_and_three_score_and_all_gutter() {

        //when
        bowlingGame.bowl(5);
        bowlingGame.bowl(4);
        bowlingGame.bowl(10);
        bowlingGame.bowl(3);
        bowlRepeat(15, 0);

        //then
        assertThat(bowlingGame.getScore(), is(25));
    }

    @Test
    public void all_gutter_and_one_strike_and_one_strike_and_nine_score() {
        bowlRepeat(18, 0);
        bowlingGame.bowl(10);
        bowlingGame.bowl(10);
        bowlingGame.bowl(9);

        assertThat(bowlingGame.getScore(), is(29));
    }

    @Test
    public void one_spare_and_six_score_three_score_and_all_gutter() {

        //when
        bowlingGame.bowl(9);
        bowlingGame.bowl(1); //spare
        bowlingGame.bowl(6);
        bowlingGame.bowl(3);
        bowlRepeat(16, 0);

        //then
        assertThat(bowlingGame.getScore(), is(25));
    }

    @Test
    public void spare_and_strike_and_spare_and_five_score_three_score_and_all_gutter() {

        //when
        bowlingGame.bowl(9);
        bowlingGame.bowl(1);
        bowlingGame.bowl(10);
        bowlingGame.bowl(9);
        bowlingGame.bowl(1);
        bowlingGame.bowl(5);
        bowlingGame.bowl(3);
        bowlRepeat(12, 0);

        //then
        assertThat(bowlingGame.getScore(), is(63));
    }

    @Test
    public void real_game () {

        //when
        bowlingGame.bowl(8);
        bowlingGame.bowl(1);
        bowlingGame.bowl(10);
        bowlingGame.bowl(10);
        bowlingGame.bowl(9);
        bowlingGame.bowl(1);
        bowlingGame.bowl(0);
        bowlingGame.bowl(4);
        bowlingGame.bowl(6);
        bowlingGame.bowl(4);
        bowlingGame.bowl(10);
        bowlingGame.bowl(10);
        bowlingGame.bowl(4);
        bowlingGame.bowl(3);
        bowlingGame.bowl(10);
        bowlingGame.bowl(5);
        bowlingGame.bowl(5);

        //then
        assertThat(bowlingGame.getScore(), is(160));
    }

    private void bowlRepeat(int bowls, int pins) {
        for(int i = 0; i< bowls; i++){
            bowlingGame.bowl(pins);
        }
    }
}