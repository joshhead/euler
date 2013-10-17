(ns euler.euler002
  (:require [euler.helper :refer [run-solution]]))

(defn fibs
  "Infinite sequence of fibonacci numbers"
  ([]
     (fibs 0 1))
  ([m n]
     (lazy-seq (cons m (fibs n (+ n m))))))

(defn solution
  "Return the sum of all even fibonacci numbers less than four million"
  []
  (->> (fibs)
       (drop 2) ; Project euler wants to skip 0, 1 and start from 1, 2, 3, 5,...
       (take-while #(<= % 4000000))
       (filter even?)
       (reduce +)))

(defn -main
  [& args]
  (run-solution solution 4613732))