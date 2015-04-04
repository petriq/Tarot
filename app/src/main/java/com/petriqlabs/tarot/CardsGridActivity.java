package com.petriqlabs.tarot;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


public class CardsGridActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards_grid);

        GridView grdCards = (GridView) findViewById(R.id.grdCards);
        grdCards.setAdapter(new CardsAdapter(this));

        grdCards.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                CardsGridItemView view = (CardsGridItemView)v;
                //Toast.makeText(CardsGridActivity.this, "" + view.getCard().getName(),
                //        Toast.LENGTH_SHORT).show();
                ShowCardDetail(view.getCard());
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_cards_grid, menu);
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

    private void ShowCardDetail(Card card)
    {
        Intent intent = new Intent(this, CardDetailActivity.class);
        Bundle bundle = new Bundle();

        bundle.putParcelable("CARD", card);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
