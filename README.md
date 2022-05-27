# stat-calculator
STATISTICAL CALCULATOR FOR INFERENCE TYPE QUESTIONS FOR THE AP STATISTICS EXAM

CREATED BY: Mandy Chen

CREATED IN: May 2022

USES: Java, Apache POI, Microsoft Excel

SUMMARY: This is a basic statistical calculator that can evaluate one and two sample confidence 
intervals and significance tests for means and proportions. It is meant to mimic what may be found on 
the AP Statistics Exam FRQs for inference type questions.

* CURRENTLY ONLY WORKS FOR ONE SAMPLE Z TEST *

TEST CASE:
COLLEGEBOARD 2021 QUESTION #4:

The manager of a large company that sells pet supplies online wants to increase sales by encouraging
repeat purchases. The manager believes that if past customers are offered $10 off their next purchase,
more than 40 percent of them will place an order. To investigate the belief, 90 customers who placed
an order in the past year are selected at random. Each of the selected customers is sent an email with
a coupon for $10 off the next purchase if the order is placed within 30 days. Of those who receive the
coupons, 38 place an order. 

Is there convincing statistical evidence, at the significance level a = 0.05, that the manager's belief 
is correct? 

Copy + Paste: 1 2 1 y y 1 90 .05 .4 .422 x

x = 30
n = 90
a = 0.05
p = 0.4
All conditions are satisfied.

OUTPUT: 

Because 0.33 is greater than 0.05 there is convincing evidence that the alternate hypothesis is correct.
