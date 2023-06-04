(ns bird-watcher)

(def last-week '[0 2 5 3 7 8 4])

(defn today [birds]
  (last birds)
  )

(defn inc-bird [birds]
  (assoc birds (- (count birds) 1) (+ (today birds) 1))
  )

(defn day-without-birds? [birds]
  (> (count (filter #(= % 0) birds)) 0)
  )

(defn n-days-count [birds n]
  (reduce + 0 (subvec birds 0 n))
  )

(defn busy-days [birds]
  (count (filter #(>= % 5) birds))
  )

(defn odd-week? [birds]
  (every? true? (for [i (range (count birds))
                      :let [x (get birds i)]]
                  (if (zero? (mod i 2)) (= x 1) (= x 0))
                  ))
  )
