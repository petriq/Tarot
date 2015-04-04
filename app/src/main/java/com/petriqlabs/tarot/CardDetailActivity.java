package com.petriqlabs.tarot;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class CardDetailActivity extends ActionBarActivity {
    private Card card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_detail);

        ImageView imgCard = (ImageView)findViewById(R.id.imgCard);
        TextView lblCardName = (TextView)findViewById(R.id.lblCardName);
        TextView lblPositiveContent = (TextView)findViewById(R.id.lblPositiveContent);
        TextView lblNegativeContent = (TextView)findViewById(R.id.lblNegativeContent);

        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            this.setCard((Card) bundle.getParcelable("CARD"));
        }

        imgCard.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCardPreview(card);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_card_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode == 1 && resultCode == Activity.RESULT_OK){
            Bundle bundle = intent.getExtras();
            if(bundle!=null) {
                this.setCard((Card) bundle.getParcelable("CARD"));
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putParcelable("CARD", card);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        // Restore state members from saved instance
        this.setCard((Card) savedInstanceState.getParcelable("CARD"));
    }

    private void showCardPreview(Card card)
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("CARD", card);
        Intent intent = new Intent(this, CardPreviewActivity.class);
        intent.putExtras(bundle);

        startActivity(intent);
    }

    private void setCard(Card card){
        this.card = card;

        ImageView imgCard = (ImageView)findViewById(R.id.imgCard);
        TextView lblCardName = (TextView)findViewById(R.id.lblCardName);
        TextView lblPositiveContent = (TextView)findViewById(R.id.lblPositiveContent);
        TextView lblNegativeContent = (TextView)findViewById(R.id.lblNegativeContent);

        imgCard.setImageResource(card.getImageResourceId());
        imgCard.setContentDescription(card.getName());
        lblCardName.setText(card.getName());
        lblPositiveContent.setText(card.getPositiveMeaning());
        lblNegativeContent.setText(card.getNegativeMeaning());

        this.setTitle(card.getName() + " (" + card.getCardRomanNumber() + ")");
    }
}
