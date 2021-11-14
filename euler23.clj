(ns euler.twentythree
  (:gen-class)
  (:require [clojure.math.combinatorics :as combo]
            [clojure.core.reducers :as r]
            [clojure.set :as s]))


(defn is-divisor? [n m]
  (= 0 (mod n m)))

(defn get-upper-bound-divisor [n] (+ 1 (int (/ n 2))))

(defn collect-divisors [n]
  (let [nums (range 1 (get-upper-bound-divisor n))]
    (->> nums
         (r/filter #(is-divisor? n %)))))

(defn find-sum-of-divs [n]
  (r/fold + (collect-divisors n)))

(defn is-abundant? [n] (> (find-sum-of-divs n) n))

(defn get-abundant-numbers [n]
  (r/foldcat (r/filter is-abundant? (range 1 n))))


(def max-domain-value 28124)

(def abundant-numbers (get-abundant-numbers max-domain-value))

(def abundant-sums
  (->> (combo/cartesian-product abundant-numbers abundant-numbers)
       (r/map #(+ (first %) (last %)))
       (r/foldcat)))


(reduce +
        (s/difference
         (set (range 1 max-domain-value))
         (set abundant-sums)))
