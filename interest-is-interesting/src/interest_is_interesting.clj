(ns interest-is-interesting)

(defn interest-rate
  "The function to calculate the interest rate based on the specified balance:
   – -3.213% for a negative balance.
   – 0.5% for a positive balance less than 1000 dollars.
   – 1.621% for a positive balance greater or equal than 1000 dollars and less than 5000 dollars.
   – 2.475% for a positive balance greater or equal than 5000 dollars.
  "
  [balance]
  (cond 
    (neg? balance) -3.213
    (< balance 1000) 0.5
    (< 999 balance 5000) 1.621
    (>= balance 5000) 2.475))

(defn annual-balance-update
  "The function to calculate the annual balance update, taking into account the interest rate"
  [balance]
  (bigdec 
    (+ balance 
      (* balance (bigdec (interest-rate balance)) 0.01M (if (neg? balance) -1M 1M)))))

(defn amount-to-donate
  "The function to calculate how much money to donate to charities based on the balance and the tax-free percentage that the government allows"
  [balance tax-free-percentage]
  (if (neg? balance)
    0
    (int (* balance tax-free-percentage 0.01 2))))