package MVP.view;

import MVP.presenter.Properties;

/**
* <h1>View Interface</h1>
*<br>Holds start and result functions
* @author  Omer Avrech & Bar Malka
* @version 1.0
* @since   29/09/2016 
*/
public interface View
{
	public Properties getPropertiesFromXml();
	public void setProperties(Properties p);
	public void start();
	public void result(Object result);
}
