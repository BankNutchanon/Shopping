package Lip;
import java.util.ArrayList;

public class ShoppingCartCalculator {

    /**
     * เขียน Javadoc ที่นี่เพื่ออธิบายกฎการทำงานและกรณีพิเศษ:
     * - จะทำอย่างไรถ้า items เป็น null หรือ empty?
     * - จะทำอย่างไรถ้า CartItem มี price หรือ quantity ติดลบ?
     * - กฎส่วนลด BOGO (ซื้อ 1 แถม 1)
     * - กฎส่วนลด BULK (ซื้อ >= 6 ชิ้น ลด 10%)
     */
    public static double calculateTotalPrice(ArrayList<CartItem> items) {
        if ( (items == null) || (items.isEmpty()) ) return 0.0 ;

        double Overallprice = 0 ;
        for (CartItem item : items) {
            double sum_price = (item.quantity() * item.price()) ;
            
            if((item.quantity() < 0) || (item.price() < 0)){
                return 0.0 ;
            } else if ( (item.sku().equals("BOGO")) && (item.quantity() >= 2) ) {
                if (item.quantity() % 2 == 0)
                    Overallprice += ( (item.quantity() / 2) * item.price() ) ;
                if (item.quantity() % 2 == 1)
                    Overallprice += ( (((item.quantity() - 1) / 2) * item.price()) + item.price() ) ;
            } else if ((item.sku().equals("BULK")) && ( item.quantity() >= 6 )) {
                Overallprice += sum_price * 0.9 ;
            } else {
                Overallprice += sum_price ;
            }   
        }
        return Overallprice ;
    }
}