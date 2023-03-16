import pytest
import math

def test_sqrt():
    num = 25
    assert math.sqrt(num) == 5

def testsquare():
    num = 7
    assert num*num == 40

def testquality():
    assert 10 == 11

@pytest.mark.activity
def test_age():
    age = 20
    year = str((2021-age)+100)
    assert year == "2101"