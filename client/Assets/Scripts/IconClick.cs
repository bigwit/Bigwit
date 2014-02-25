using UnityEngine;

public class IconClick : MonoBehaviour
{
	void Start()
	{
	}

	void Update()
	{
		if (Input.GetMouseButtonDown(0))
		{
			Vector3 correctPosition = Camera.main.ScreenToWorldPoint(Input.mousePosition);
			Collider2D aim = Physics2D.OverlapPoint(new Vector2(correctPosition.x, correctPosition.y));
			if (aim != null)
			{
				StaticParameters parameters = StaticParameters.Instance;
				parameters.SetParameter(Parameters.TypeOfLevel, LevelTypes.BankRobed);
				Application.LoadLevel("ChoosingLevels");
			}
		}
	}
}