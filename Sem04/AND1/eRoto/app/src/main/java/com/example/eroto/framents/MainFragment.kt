package com.example.eroto.framents

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eroto.R
import com.example.eroto.models.Market
import com.example.eroto.adapters.MarketViewAdapter
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.utils.Utils

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    private lateinit var barChart: BarChart
    private lateinit var lineChart: LineChart
    private lateinit var marketRecycler: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        barChart = view.findViewById(R.id.bigMoversChart)
        setupChart()

        lineChart = view.findViewById(R.id.lineChart)
        setUpLineChart()

        marketRecycler = view.findViewById(R.id.market_recycler)
        loadMarketsData()

        loadPieChartData()
        loadLineChartData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_screen, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment main_screen.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun loadMarketsData() {
        var markets = ArrayList<Market>()
        markets.add(Market("NSDQ100", 1222.2, 0.5))
        markets.add(Market("SPY50", 1222.0, 0.5))
        markets.add(Market("HLABAALA100", 1222.2, 0.5))
        markets.add(Market("HUN10", 122.2, 0.5))

        var adapter = MarketViewAdapter()

        adapter.marketList = markets

        var layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        marketRecycler.layoutManager = layoutManager
        marketRecycler.adapter = adapter
    }

    private fun setUpLineChart() {
        lineChart.xAxis.isEnabled = false
        lineChart.axisLeft.isEnabled = false
        lineChart.axisRight.isEnabled = false

        lineChart.legend.isEnabled = false
        lineChart.description.isEnabled = false
        lineChart.setScaleEnabled(false)
    }

    private fun loadLineChartData() {
        var values = ArrayList<Entry>()
        values.add(Entry(10f, 10f))
        values.add(Entry(15f, 18f))
        values.add(Entry(30f, 15f))
        values.add(Entry(40f, 30f))
        values.add(Entry(50f, 25f))
        values.add(Entry(80f, 40f))
        values.add(Entry(100f, 30f))

        val lineDataSet = LineDataSet(values, "")

        lineDataSet.setDrawFilled(true)
        if (Utils.getSDKInt() >= 18) {
            val drawable = ContextCompat.getDrawable(activity?.applicationContext!!, R.drawable.fade)
            lineDataSet.fillDrawable = drawable
        } else {
            lineDataSet.fillColor = Color.parseColor("#4bdf2b")
        }

        lineDataSet.mode = LineDataSet.Mode.CUBIC_BEZIER
        lineDataSet.color = Color.parseColor("#4bdf2b")

        lineDataSet.setDrawValues(false)
        lineDataSet.setDrawCircles(false)
        lineDataSet.setDrawHorizontalHighlightIndicator(false)
        lineDataSet.setDrawVerticalHighlightIndicator(false)

        val lineData = LineData(lineDataSet)
        lineChart.data = lineData
    }

    private fun setupChart() {
        barChart.axisLeft.isEnabled = false
        barChart.xAxis.isEnabled = false
        barChart.axisRight.isEnabled = false

        barChart.legend.isEnabled = false
        barChart.description.isEnabled = false
        barChart.setScaleEnabled(false)
    }

    private fun loadPieChartData() {
        var entries = ArrayList<BarEntry>()
        entries.add(BarEntry(1f, 11.78f))
        entries.add(BarEntry(2f, 9.66f))
        entries.add(BarEntry(3f, 2.98f))
        entries.add(BarEntry(4f, 2.01f))
        entries.add(BarEntry(5f, 1.83f))

        var dataSet = BarDataSet(entries, "")
        dataSet.valueTextSize = 15f
        dataSet.setGradientColor(Color.parseColor("#41b727"), Color.parseColor("#4bdf2b"))
        dataSet.valueTextColor = Color.parseColor("#4ad929")
        dataSet.highLightAlpha = 0
        val barData = BarData(dataSet)
        barData.barWidth = 0.4f
        barChart.data = barData
        barChart.invalidate()
    }
}