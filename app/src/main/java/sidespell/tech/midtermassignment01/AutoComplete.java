package sidespell.tech.midtermassignment01;

/**
 * Created by Lougie on 12/01/2016.
 */

import java.util.HashMap;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
public class AutoComplete extends AutoCompleteTextView{

    public AutoComplete(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected CharSequence convertSelectionToString(Object selectedItem) {
        /** Each item in the autocompetetextview suggestion list is a hashmap object */
        HashMap<String, String> hm = (HashMap<String, String>) selectedItem;
        return hm.get("txt");
    }


}
