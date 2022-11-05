(ns user)


(defn is-sum-number? [n k numbers]
  (= 0 (- n (reduce + (map #(int (Math/pow % k)) numbers)))))

(defn produce-numbers [n]
  (map inc (range -1 n)))

(defn split-integer [n]
  (map #(Character/digit % 10) (.toCharArray (String/valueOf n))))

(let [values (filter #(= true (is-sum-number? % 5 (split-integer %))) (produce-numbers 1000000))]
  (reduce + (drop 2 values)))
