(ns cars-assemble)

(def cars_per_hour 221)

(defn rate 
  [speed]
  (cond
    (<= 1 speed 4) 100
    (<= 5 speed 8) 90
    (= speed 9) 80
    (= speed 10) 77
    :else 0
  )
)

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (/ (* (rate speed) cars_per_hour speed) 100.0)
  )

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (int (/ (production-rate speed) 60))
  )
