package cn.microdone.gesture;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Spinner_Adapter extends BaseAdapter{
	private  LayoutInflater mInflater = null;
	private List<ListEncryptionMode> list;
	private Context context;// ������

	public Spinner_Adapter(Context context ,List<ListEncryptionMode> list){
		this.context=context;
		this.list=list;
		this.mInflater = LayoutInflater.from(context);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();

	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);

	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		 ViewHolder holder = null;
	
		                 if (convertView == null) {
		                      
		                     holder=new ViewHolder(); 
		                      
		                     convertView = mInflater.inflate(R.layout.ad_spinner, null);
		                     holder.title = (TextView)convertView.findViewById(R.id.text);
		                  
		                    convertView.setTag(holder);
		                     
		                }else {
		                     
		                   holder = (ViewHolder)convertView.getTag();
		                 }
		                 holder.title.setText(list.get(position).getEncryptionMode());   
		                 

		return convertView;

	}
	   public final class ViewHolder{
		             public TextView title;
		           }

}
