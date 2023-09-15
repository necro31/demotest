package com.albert.demotest.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Grade {
    MANAGER {
        @Override
        public Long calculateBonus(Long salary) {
            return (10 * salary) / 100;
        }
    }, SUPERVISOR {
        @Override
        public Long calculateBonus(Long salary) {
            return (6 * salary) / 100;
        }
    }, STAFF {
        @Override
        public Long calculateBonus(Long salary) {
            return (3 * salary) / 100;
        }
    };

    public static Long calculateSalaryWithBonusByGrade(Grade grade, Long salary) {
        return grade.calculateBonus(salary) + salary;
    }

    public abstract Long calculateBonus(Long salary);
}
