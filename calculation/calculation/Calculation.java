package calculation;

public abstract class Calculation<V>
{	
	protected V _result;
	
	public abstract Calculation<V> execute();
	
	public V getResult()
	{
		return _result;
	}
}
