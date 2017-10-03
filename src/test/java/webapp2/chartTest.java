package webapp2;

import org.junit.Test;

import com.uc.web.forms.ui.flot.PlotChart;
import com.uc.web.forms.ui.flot.PlotChartImpl;
import com.uc.web.forms.ui.flot.PlotItem;
import com.uc.web.forms.ui.flot.PlotItemCollection;
import com.uc.web.forms.ui.flot.PlotItemCollectionImpl;
import com.uc.web.forms.ui.flot.PlotItemImpl;
import com.uc.web.forms.ui.flot.PlotPoint;
import com.uc.web.forms.ui.flot.PlotPointCollection;
import com.uc.web.forms.ui.flot.PlotPointCollectionImpl;
import com.uc.web.forms.ui.flot.PlotPointImpl;
import com.uc.web.forms.ui.flot.PlotSeriesCollectionImpl;
import com.uc.web.forms.ui.flot.PlotSeriesImpl;
import com.uc.web.forms.ui.flot.PlotValue;
import com.uc.web.forms.ui.flot.PlotValueCollection;
import com.uc.web.forms.ui.flot.PlotValueCollectionImpl;
import com.uc.web.forms.ui.flot.PlotValueImpl;

public class chartTest {
	
	@Test
	public void test(){
		
		PlotValue plotValue=new PlotValueImpl(new Object[]{"12","3","45", 1, 2, new Object[]{"4", 5}});
		System.err.println(plotValue.toJson());
		plotValue=new PlotValueImpl(plotValue);
		System.err.println(plotValue.toJson());
		
		PlotValueCollection valueCollection=new PlotValueCollectionImpl();
		valueCollection.add(plotValue);
		valueCollection.add(new PlotValueImpl(1));
		System.err.println(valueCollection.toJson());
		
		PlotPoint point=new PlotPointImpl(1, 2);
		
		System.err.println(point.toJson());
		
		PlotPointCollection pointCollection=new PlotPointCollectionImpl();
		pointCollection.add(new PlotPointImpl("1", 1));
		pointCollection.add(new PlotPointImpl("2", 1));
		pointCollection.add(new PlotPointImpl("3", 1));
		
		System.err.println(pointCollection.toJson());
		
		PlotItem item=new PlotItemImpl("abc", "23");
		System.err.println(item.toJson());
		
		System.err.println(new PlotValueImpl(item).toJson());
		
		PlotItemCollection itemCollection=new PlotItemCollectionImpl();
		itemCollection.add(item);		
		itemCollection.add(new PlotItemImpl("x", new Object[]{1,2,3}));
		System.err.println(itemCollection.toJson());
		
		PlotChart plotChart=new PlotChartImpl(
				new PlotSeriesCollectionImpl()
				.addSeries(new PlotSeriesImpl("series1", 
						new PlotValueCollectionImpl()
						.addValue(new PlotValueImpl(1))
						.addValue(new PlotValueImpl(2))
						.addValue(3)						
						))
				.addSeries(new PlotSeriesImpl("series2", new PlotValueCollectionImpl()
						.addValue("1")
						.addValue(3)
						.addValue(true)))
				,
				null
				);
		System.err.println("----------------------------");
		System.err.println(plotChart.toJson());
		
		plotChart=new PlotChartImpl(
				new PlotItemImpl("data",
						new PlotItemCollectionImpl()
						.addValue(new PlotItemImpl("name", "访问来源"))
						.addValue(new PlotItemImpl("type", "pie"))
						.addValue(new PlotItemImpl("center",new String[]{"50%", "55%"}))
						.addValue(new PlotItemImpl("data",	new PlotValueCollectionImpl()
								.addValue(new PlotValueCollectionImpl()
										.addValue(new PlotPointImpl("value", 335))
										.addValue(new PlotPointImpl("name", "直接访问"))
										)
								.addValue(new PlotValueCollectionImpl()
										.addValue(new PlotPointImpl("value", 367))
										.addValue(new PlotPointImpl("name", "其他"))
										)
								)
								)
								)
				,null);
		System.err.println("======================");
		System.err.println(plotChart.toJson());
		System.err.println("======================");
		PlotValue value=new PlotItemImpl("dataSet", 
				new PlotItemCollectionImpl()
				.addValue(new PlotItemImpl("data",
						new PlotValueCollectionImpl()
						.addValue(
								new PlotItemCollectionImpl()
								.addValue(new PlotItemImpl("value", 367))
								.addValue(new PlotItemImpl("name", "其他"))
								)
						.addValue(
								new PlotItemCollectionImpl()
								.addValue(new PlotItemImpl("value", 357))
								.addValue(new PlotItemImpl("name", "ABC"))
								)
						)						
					)
				.addValue(new PlotItemImpl("type", "pie"))
				.addValue(new PlotItemImpl("name", "pie chart")));
		
		System.err.println(value.toJson());
		
		
	}

}
