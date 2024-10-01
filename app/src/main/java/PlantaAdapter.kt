import android.database.DataSetObserver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListAdapter
import android.widget.TextView
import com.empresa.verdejar.MainActivity

class PlantaAdapter(private val plantas: List<Planta>, mainActivity: MainActivity) : BaseAdapter(), ListAdapter {
    override fun registerDataSetObserver(p0: DataSetObserver?) {
        TODO("Not yet implemented")
    }

    override fun unregisterDataSetObserver(p0: DataSetObserver?) {
        TODO("Not yet implemented")
    }

    override fun getCount(): Int = plantas.size

    override fun getItem(position: Int): Any = plantas[position]

    override fun getItemId(position: Int): Long = position.toLong()
    override fun hasStableIds(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val planta = plantas[position]
        val view = convertView ?: LayoutInflater.from(parent?.context).inflate(android.R.layout.simple_list_item_2, parent, false)
        val text1 = view.findViewById<TextView>(android.R.id.text1)
        val text2 = view.findViewById<TextView>(android.R.id.text2)
        text1.text = planta.nome
        text2.text = "${planta.dataPlantio} - ${planta.nivelCuidado} - ${if (planta.precisaDeAgua) "Precisa de água" else "Crescendo bem"}"
        return view
    }

    override fun getItemViewType(p0: Int): Int {
        TODO("Not yet implemented")
    }

    override fun getViewTypeCount(): Int {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun areAllItemsEnabled(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEnabled(p0: Int): Boolean {
        TODO("Not yet implemented")
    }
}
