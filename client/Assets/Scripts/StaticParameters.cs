using UnityEngine;
using System.Collections.Generic;

public class StaticParameters : MonoBehaviour
{
	public static StaticParameters Instance
	{
		get;
		private set;
	}

	Dictionary<Parameters, object> parameters = new Dictionary<Parameters, object>();

	void Start() 
	{
		Instance = this;
		DontDestroyOnLoad(this);
		Object[] objs = Object.FindObjectsOfType(typeof(StaticParameters));
		int counter = objs.Length * 5;
		while (objs.Length > 1)
		{
			Object.DestroyImmediate(objs[1]);
			counter--;
			if (counter <= 0)
				break;
		}
		// TODO: Add initial parameters to dictionary
	}

	void Update()
	{
	}

	/// <summary>
	/// Gets the parameter
	/// </summary>
	/// <returns>The parameter</returns>
	/// <param name="name">Name of parameter</param>
	/// <exception cref="KeyNotFoundException">If there is not this parameter</exception>
	public object GetParameter(Parameters name)
	{
		return parameters[name];
	}

	public void SetParameter(Parameters name, object value, bool overwrite = true)
	{
		if (overwrite || !parameters.ContainsKey(name))
		{
			parameters[name] = value;
		}
	}

	public int Count()
	{
		return parameters.Count;
	}
}

public enum Parameters
{
	TypeOfLevel
}

public enum LevelTypes
{
	BankRobed
}