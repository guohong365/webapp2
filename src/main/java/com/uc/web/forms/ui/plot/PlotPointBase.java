package com.uc.web.forms.ui.plot;

public class PlotPointBase<XType, YType> implements PlotPoint<XType, YType> {
		private XType x;
		private YType y;
		public PlotPointBase() {
		}
		public PlotPointBase(XType x, YType y){
			this.x=x;
			this.y=y;
		}
		
		public String toJson(){		
			return "[" + getX().toString() + "," + getY().toString() +"]";
		}
		public XType getX() {
			return x;
		}
		public void setX(XType x) {
			this.x = x;
		}
		public YType getY() {
			return y;
		}
		public void setY(YType y) {
			this.y = y;
		}
	}
