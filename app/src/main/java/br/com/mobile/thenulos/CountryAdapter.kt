package br.com.mobile.thenulos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.widget.TextViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class CountryAdapter(
    val paises: List<Country>,
    val onCLick: (Country) -> Unit
): RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(view: View): RecyclerView.ViewHolder(view){
                val cardNome: TextView
                val cardCapital: TextView
                val cardImg: ImageView
                val cardProgress: ProgressBar
                var cardView: CardView
//                val cardPopulacao: TextView
//                val cardContinente: TextView
//                val cardLatitude: TextView
//                val cardLongitude: TextView

                init {
                    cardNome = view.findViewById<TextView>(R.id.card_nome)
                    cardCapital = view.findViewById<TextView>(R.id.card_capital)
                    cardImg = view.findViewById<ImageView>(R.id.card_img)
                    cardProgress = view.findViewById<ProgressBar>(R.id.card_progress)
                    cardView = view.findViewById<CardView>(R.id.card_paises)
                }
            }

    override fun getItemCount() = this.paises.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder{
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_country, parent, false)
        val holder = CountryViewHolder(view)

        return holder

    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val context = holder.itemView.context
        val pais = paises[position]

        holder.cardNome.text = pais.pais
        holder.cardCapital.text = pais.capital
        holder.cardProgress.visibility = View.VISIBLE

        Picasso.with(context).load(pais.bandeira).fit().into(holder.cardImg, object: com.squareup.picasso.Callback{
                override fun onSuccess() {
                    holder.cardProgress.visibility = View.GONE
                }

                override fun onError() {
                    holder.cardProgress.visibility = View.GONE
                }
            })

        holder.itemView.setOnClickListener{onCLick(pais)}
    }
}