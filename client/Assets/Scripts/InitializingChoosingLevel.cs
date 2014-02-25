using UnityEngine;
using System;

public class InitializingChoosingLevel : MonoBehaviour
{
	void Start()
	{
	}

	void Update()
	{
	}

	void OnLevelWasLoaded(int level)
	{
		StaticParameters parameters = StaticParameters.Instance;
		try
		{
			var lvl = (LevelTypes)parameters.GetParameter(Parameters.TypeOfLevel);
			switch (lvl)
			{
				case LevelTypes.BankRobed:
				{
					LoadLevelBankWasRobed();
					break;
				}
				default:
				{
					throw new UnityException();
				}
			}
		}
		catch (Exception e)
		{
			Debug.Log(e.Message);
			Debug.Log(e.StackTrace);
			Debug.LogError("Can't load choosing level");
			Application.LoadLevel("MainMap");
		}
	}

	private void LoadLevelBankWasRobed()
	{
		Sprite[] sprites = Resources.LoadAll<Sprite>(@"Graphics/levelsSelection");
		double offset = 0;
		foreach(var sprite in sprites)
		{
			var button = new GameObject("Button");
			button.transform.parent = GameObject.Find("Foreground").transform;
			button.AddComponent(typeof(SpriteRenderer));
			button.transform.position = new Vector3(0, (float)-offset * 2 * Camera.main.orthographicSize / Screen.height);
			var renderer = button.GetComponent<SpriteRenderer>();
			renderer.sprite = sprite;
			offset += 10 + sprite.rect.height;
		}
	}
}