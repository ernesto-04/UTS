package main.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts.R;

import java.util.List;

import main.DetailProduct;
import model.Product;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> products;
    private Context context;

    public ProductAdapter(Context context, List<Product> products) {
        this.products = products;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
        Product p = products.get(position);
        holder.productPrice.setText("Rp" + p.getPrice());
        holder.productName.setText(p.getName());
        holder.imageView.setImageResource(p.getImage());
//        AssetManager assetManager = context.getAssets();
//        try {
//            InputStream inputStream = assetManager.open(p.getImage());
//            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
//            holder.imageView.setImageBitmap(bitmap);
//        } catch (Exception e) {
////            throw new RuntimeException(e);
//        }
        holder.itemView.setOnClickListener((v) -> {
            Intent intent = new Intent(context, DetailProduct.class);
            intent.putExtra("image", p.getImage());
            intent.putExtra("price", p.getPrice());
            intent.putExtra("name", p.getName());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView productName, productPrice;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_product);
            productName = itemView.findViewById(R.id.product_name);
            productPrice = itemView.findViewById(R.id.product_price);
        }
    }
}
