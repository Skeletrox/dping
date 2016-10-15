#include <iostream>

using namespace std;

void isfact(int x)
{
	float y = (float) x;
	int i=1;
	do
	{
		y /= i++;
	}while (y>1);
	if (y==1)
		cout << i-1 << "!" << endl;
	else
		cout << "NONE" << endl;
}

int main()
{
	int x;
	cin >> x;
	isfact(x);
	return 0;
}
