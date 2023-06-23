(ns log-levels
  (:require [clojure.string :as str]))

(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  (->
    s
    (str/replace #"\[.*\]:" "")
    (str/trim)
  )
  )

(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  (->
    s
    (str/split #"[\[\]]")
    (get 1)
    (str/lower-case)
  )
  )

(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  (let [a (str/split s #"[\[\]\:]")]
      (str 
        (str/trim (get a 3)) 
        " ("
        (str/lower-case (get a 1))
        ")")
    )
  )
