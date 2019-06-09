package se.umu.cs.johane.savestateexercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StateActivity extends AppCompatActivity {
    private final String STATE_DIE = "die";
    Die die;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state);

        if(savedInstanceState != null) {
            die = savedInstanceState.getParcelable(STATE_DIE);
        } else {
            die=new Die();
        }

        setValueText();
    }

    private void setValueText() {
        TextView view=this.findViewById(R.id.value);
        view.setText(""+die.getValue());
    }

    public void rollDice(View src){
        die.roll();
        setValueText();
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putParcelable(STATE_DIE, die);
        super.onSaveInstanceState(savedInstanceState);
    }
}
