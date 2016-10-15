#include <iostream>

using namespace std;

int main()
{
	int x, digit, max=0, xarray[4]={0,0,0,0}, i=0, j=0;
	int big=0, small=0, res=0;
	cin >> x;
	do
	{
		digit=x%10;
		xarray[i++]=digit;
		x=x/10;
	}while (x > 0);	
	for (i=0;i<4;i++)
		for (j=0;j<4-i-1;j++)
		{
			if (xarray[j] > xarray[j+1])
			{
				xarray[j] = xarray[j] + xarray[j+1];
				xarray[j+1] = xarray[j] - xarray[j+1];
				xarray[j] = xarray[j] - xarray[j+1];
			}
		}
	max=xarray[3];
	for (i=0;i<4;i++)
	{
		small = small*10 + xarray[i];
		big = big*10 + xarray[3-i];
	}
	res = big - small;
	cout << max << endl << big << endl << small << endl << res << endl;
	return 0;
}
