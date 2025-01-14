package com.example.uts;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import main.adapter.ProductAdapter;
import model.Product;

public class MainActivity extends AppCompatActivity {

    private List<Product> products = new ArrayList<>();
    private RecyclerView rvProduct;
    private ProductAdapter adapter;
    Button addfragment, showfragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//        rvProduct = findViewById(R.id.rv_product);
//        rvProduct.setLayoutManager(new LinearLayoutManager(this));
//
//        products.add(new Product("Sush", 1000, R.drawable.sushi));
//        products.add(new Product("Sushi", 2000, R.drawable.sushi));
//        products.add(new Product("Sushii", 3000, R.drawable.sushi));
//
//        adapter = new ProductAdapter(this, products);
//        rvProduct.setAdapter(adapter);

        addfragment = findViewById(R.id.addfragment_btn);
        addfragment.setOnClickListener(v->{
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new AddFragment()).commit();
        });

        showfragment = findViewById(R.id.showfragment_btn);
        showfragment.setOnClickListener(v->{
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new ShowFragment()).commit();
        });

    }
}