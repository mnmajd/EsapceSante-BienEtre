/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;

/**
 *
 * @author oualha
 */
public class ImageEditor {
    
public void setImageOn(Label node, String path, int fitWidth, int fitHeight) {
        try {
            ImageView imageView = new ImageView();
            imageView.setImage(new Image(path));
            imageView.setFitWidth(fitWidth);
            imageView.setFitHeight(fitHeight);
            node.setGraphic(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setImageOn(Label node, byte[] image, int fitWidth, int fitHeight) {
        try {
            ImageView imageView = new ImageView();

            ByteArrayInputStream in = new ByteArrayInputStream(image);
            BufferedImage read = ImageIO.read(in);
            imageView.setImage(SwingFXUtils.toFXImage(read, null));
            imageView.setFitWidth(fitWidth);
            imageView.setFitHeight(fitHeight);
            node.setGraphic(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
