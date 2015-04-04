package com.petriqlabs.tarot;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class CardPreviewActivity extends ActionBarActivity {
    Card card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_preview);

        Bundle bundle = this.getIntent().getExtras();

        if(bundle!=null) {
            this.card = (Card)bundle.getParcelable("CARD");
            ImageView imgCard = (ImageView)findViewById(R.id.imgCard);

            imgCard.setImageResource(card.getImageResourceId());
            imgCard.setContentDescription(card.getName());
            this.setTitle(card.getName() + " (" + card.getCardRomanNumber() + ")");
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_card_preview, menu);
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

        switch (id)
        {
            case android.R.id.home:
                Bundle bundle = new Bundle();
                bundle.putParcelable("CARD", card);
                Intent intent = new Intent(this, CardDetailActivity.class);
                intent.putExtras(bundle);

                NavUtils.navigateUpTo(this, intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
/*
    @Override
    public void onBackPressed() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("CARD", card);
        Intent intent = new Intent(this, CardPreviewActivity.class);
        intent.putExtras(bundle);
        setResult(Activity.RESULT_OK, intent);
        super.onBackPressed();
    }
*/
}
