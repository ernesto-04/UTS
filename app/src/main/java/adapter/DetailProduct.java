package adapter;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uts.R;

public class DetailProduct extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_product);

        ImageView image = findViewById(R.id.iv_product);
        TextView name = findViewById(R.id.product_name);
        TextView price = findViewById(R.id.product_price);

        int imageId = getIntent().getIntExtra("image", 0);
        String productName = getIntent().getStringExtra("name");
        int productPrice = getIntent().getIntExtra("price", 0);

        image.setImageResource(imageId);
        name.setText(productName);
        price.setText("Rp " + productPrice);

    }
}
