/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utile;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 *
 * @author oualha
 */
public class AnimationGenerator {
    
public void applyRotationOn(Node node, int duration, double angle, int cycleCount) {
        RotateTransition rotateTransition
                = new RotateTransition(Duration.millis(duration), node);
        rotateTransition.setByAngle(angle);
        rotateTransition.setCycleCount(cycleCount);
        rotateTransition.setAutoReverse(true);
        rotateTransition.play();
    }

    public void applyTranslateAnimationOn(Node node, int duration, double from, double to) {
        TranslateTransition translateTransition
                = new TranslateTransition(Duration.millis(duration), node);
        translateTransition.setFromX(from);
        translateTransition.setToX(to);
        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(true);
        translateTransition.play();
    }
    public void applyTranslateAnimationOn(Node node, int duration, double from, double to, EventHandler<ActionEvent> eventHandler) {
        TranslateTransition translateTransition
                = new TranslateTransition(Duration.millis(duration), node);
        translateTransition.setOnFinished(eventHandler);
        translateTransition.setFromX(from);
        translateTransition.setToX(to);
        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(true);
        translateTransition.play();
    }

    public void applyFadeAnimationOn(Node node, int duration, double from, double to, EventHandler<ActionEvent> eventHandler) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(duration), node);
        fadeTransition.setOnFinished(eventHandler);
        fadeTransition.setFromValue(from);
        fadeTransition.setToValue(to);
        fadeTransition.setAutoReverse(true);
        fadeTransition.setCycleCount(1);
        fadeTransition.play();
    }

}

