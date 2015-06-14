(ns euler.019
  (:require [joda-time :as jt]))

(def twentieth-century 
  (jt/interval (jt/date-time "1901-01-01") (jt/date-time "2001-01-01")))

(def all-the-days
  (take (jt/days-in twentieth-century) 
        (jt/iterate jt/plus (jt/date-time "1901-01-01")
                            (jt/days 1)))) 

(defn sunday? [day]
  (= 7 (.getDayOfWeek day)))

(defn first-of-month? [day]
  (= 1 (.getDayOfMonth day)))

(count (filter (every-pred sunday? first-of-month?) all-the-days))
